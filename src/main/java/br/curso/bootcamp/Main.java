package br.curso.bootcamp;

import br.curso.bootcamp.dominio.Bootcamp;
import br.curso.bootcamp.dominio.Curso;
import br.curso.bootcamp.dominio.Dev;
import br.curso.bootcamp.dominio.Mentoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bootcamp bootcamp = mockBootcamp();

        List<Dev> devs = new ArrayList<>();
        devs.add(new Dev("Camila"));
        devs.add(new Dev("João"));
        devs.add(new Dev("Tiago"));

        devs.get(0).inscreverBootcamp(bootcamp);
        devs.get(0).progredir();
        devs.get(0).progredir();

        devs.get(1).inscreverBootcamp(bootcamp);
        devs.get(1).progredir();
        devs.get(1).progredir();
        devs.get(1).progredir();

        for (Dev dev:devs) {
            System.out.println("=============================================");
            System.out.println("Aluno:\n\t" + dev.getNome());
            if (!dev.getConteudosInscritos().isEmpty() || !dev.getConteudosConcluidos().isEmpty()) {
                System.out.println("Conteúdos Pendentes:\n\t" + (dev.getConteudosInscritos().isEmpty() ? "Bootcamp concluído" : dev.getConteudosInscritos()));
                System.out.println("Conteúdos Concluidos:\n\t" + dev.getConteudosConcluidos());
                System.out.println("XP:\n\t" + dev.calcularTotalXp());
            }
        }

    }

    private static Bootcamp mockBootcamp() {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso java");
        curso1.setCargaHoraria(18);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso js");
        curso2.setDescricao("Descrição curso js");
        curso2.setCargaHoraria(18);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de java");
        mentoria.setDescricao("Descrição mentoria java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(mentoria);
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);

        return bootcamp;
    }
}