package br.edu.unisep.funcoes;

import br.edu.unisep.model.Tarefa;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Funcoes {

    public Funcoes(){}


    public void verificarExistencia()
    {
        File pasta = new File("C:\\Lista");
        try
        {
            if(!pasta.exists())
            {
                pasta.mkdir();
                File tarefas = new File(pasta, "tarefas.txt");
                tarefas.createNewFile();
            }
            else
            {
                File tarefas = new File(pasta, "tarefas.txt");
                if(!tarefas.exists())
                {
                    tarefas.createNewFile();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public List<Tarefa> lerTarefas()
    {
        List<Tarefa> tarefas = new ArrayList<Tarefa>();

        File pasta = new File("C:\\Lista");
        File tarefa = new File(pasta,"tarefas.txt");
        if(tarefa.exists())
        {
            try
            {
                FileReader fr = new FileReader(tarefa);
                BufferedReader br = new BufferedReader(fr);

                String linha;
                while ((linha = br.readLine()) != null)
                {
                    Tarefa tarefaObjt = new Tarefa();
                    String[] Linhas = linha.split(";");
                    tarefaObjt.setTarefa(Linhas[0]);
                    tarefaObjt.setStatus(Integer.parseInt(Linhas[1]));

                    tarefas.add(tarefaObjt);
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Arquivo corrompido");
                e.printStackTrace();
            }
        }
        return tarefas;
    }


        public List<Tarefa> excluirTarefa(List<Tarefa> tarefas)
        {
            try
            {
                String idExcluso = JOptionPane.showInputDialog("Qual o index da tarefa que deseja excluir:");
                if(idExcluso != null)
                {
                    if(!idExcluso.isEmpty())
                    {
                        int id = Integer.parseInt(idExcluso);
                        tarefas.remove(id - 1);
                    }
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir tarefa");
                return tarefas;
            }
            return tarefas;
        }


        public List<Tarefa> marcarComoConcluido(List<Tarefa> tarefinhas)
        {
            try
            {
                String index = JOptionPane.showInputDialog("Digite o numero do item que concluiu:");
                if(index != null) {
                    if (!index.isEmpty()) {
                        int id = Integer.parseInt(index);
                        tarefinhas.get(id - 1).setStatus(1);
                    }
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Erro ao concluir tarefa");
                return tarefinhas;
            }
            return tarefinhas;
        }


        public List<Tarefa> adicionarTarefa(List<Tarefa> lista)
        {
            String tarefa = JOptionPane.showInputDialog("Digite a nova tarefa:");
            if(tarefa != null)
            {
                if(!tarefa.isEmpty())
                {
                    Tarefa tarefaObjt = new Tarefa(tarefa,false);
                    lista.add(tarefaObjt);
                    return lista;
                }
            }
            return lista;
        }


        public void sairESalvar(List<Tarefa> tarefas)
        {
            File pasta = new File("C:\\Lista");
            File tarefa = new File(pasta,"tarefas.txt");

            String texto = "";
            for (int i = 0; i < tarefas.size(); i++) {
                texto += tarefas.get(i).getTarefa()+";";

                String status = "";
                if(tarefas.get(i).isStatus())
                {
                    status="1";
                }
                else
                {
                    status="0";
                }
                texto = texto + status + "\n";
            }
            try
            {
                FileWriter fw = new FileWriter(tarefa,false);
                fw.write(texto);
                fw.close();
                JOptionPane.showMessageDialog(null,"Atualizações feitas com sucesso!");
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            }
        }
}
