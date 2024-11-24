package br.edu.unisep.view;

import br.edu.unisep.funcoes.Funcoes;
import br.edu.unisep.model.Tarefa;
import br.edu.unisep.telas.Listagem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args)
    {
        Funcoes funcoes = new Funcoes();
        List<Tarefa> tarefas = funcoes.lerTarefas();

        funcoes.verificarExistencia();
        JFrame frame = new JFrame();
        frame.setTitle("Lista de compras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

        JPanel painelPrincipal = new JPanel();

        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        //Adicionar tarefa
        JPanel JPAdicionarTarefa = new JPanel();
        JButton JBAdicionarTarefa = new JButton("Adicionar");
        JBAdicionarTarefa.addActionListener(e ->
        {
           funcoes.adicionarTarefa(tarefas);
        });
        JPAdicionarTarefa.add(JBAdicionarTarefa);

        //Marcar Como Concluida
        JPanel JPMarcarComoConcluida = new JPanel();
        JButton JBMarcarComoConcluida = new JButton("Marcar como concluida");
        JBMarcarComoConcluida.addActionListener(e ->
        {
            funcoes.marcarComoConcluido(tarefas);
        });
        JPMarcarComoConcluida.add(JBMarcarComoConcluida);

        //Remover da lista
        JPanel JPRemover = new JPanel();
        JButton JBRemover = new JButton("Remover da lista");
        JBRemover.addActionListener(e ->
        {
            funcoes.excluirTarefa(tarefas);
        });
        JPRemover.add(JBRemover);

        //Exibir todas as tarefas
        JPanel JPExibir = new JPanel();
        JButton JBExibir = new JButton("Exibir a lista");
        JBExibir.addActionListener(e ->
        {
            Listagem listagem = new Listagem();
            listagem.Listagem(tarefas);
        });
        JPExibir.add(JBExibir);

        //Sair do programa
        JPanel JPSair = new JPanel();
        JButton JBSair = new JButton("Sair");
        JBSair.addActionListener(e ->
        {
            funcoes.sairESalvar(tarefas);
            System.exit(0);
        });
        JPSair.add(JBSair);

        painelPrincipal.add(JPAdicionarTarefa);
        painelPrincipal.add(JPMarcarComoConcluida);
        painelPrincipal.add(JBRemover);
        painelPrincipal.add(JPExibir);
        painelPrincipal.add(JPSair);

        frame.add(painelPrincipal);
        painelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        frame.setVisible(true);
    }
}
