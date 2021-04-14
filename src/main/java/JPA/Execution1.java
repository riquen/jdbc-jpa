package JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Execution1 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        Estado estadoAdd = new Estado("Minas Gerais", "MG");
//        Aluno alunoAdd = new Aluno("Rique", 24, estadoAdd);

//        entityManager.getTransaction().begin();

//        entityManager.persist(estadoAdd);
//        entityManager.persist(alunoAdd);

//        entityManager.getTransaction().commit();

//        Estado estadoFound = entityManager.find(Estado.class, 1);
//        Aluno alunoFound = entityManager.find(Aluno.class, 1);

//        System.out.println(estadoFound);
//        System.out.println(alunoFound);

//        entityManager.getTransaction().begin();

//        alunoFound.setNome("Henrique");
//        alunoFound.setIdade(25);

//        entityManager.getTransaction().commit();

//        entityManager.getTransaction().begin();

//        entityManager.remove(alunoFound);

//        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
