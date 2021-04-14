package JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Execution2 {
    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        entityManager.getTransaction().begin();

//        Estado estadoAdd = new Estado("Minas Gerais", "MG");
//        entityManager.persist(estadoAdd);
//        entityManager.persist(new Estado("Rio de Janeiro", "RJ"));
//        entityManager.persist(new Aluno("Vivianne", 29, estadoAdd));
//        entityManager.persist(new Aluno("Henrique", 25, estadoAdd));
//        entityManager.persist(new Aluno("Loki", 8, estadoAdd));

//        entityManager.getTransaction().commit();

//        String nome = "Henrique";

//        Aluno alunoEntityManager = entityManager.find(Aluno.class, 1);
//        System.out.println("Consulta alunoEntityManager: " + alunoEntityManager);

//        String sql = "SELECT * FROM Aluno WHERE nome = :nome ";
//        Aluno alunoSQL = (Aluno) entityManager
//                .createNativeQuery(sql, Aluno.class)
//                .setParameter("nome", nome)
//                .getSingleResult();

//        String sqlList = "SELECT * FROM Aluno";
//        List<Aluno> alunoSQLList = entityManager
//                .createNativeQuery(sqlList, Aluno.class)
//                .getResultList();

//        System.out.println("Consulta alunoSQL: " + alunoSQL);
//        alunoSQLList.forEach(Aluno -> System.out.println("Consulta alunoSQLList: " + Aluno));

//        String jpql = "select a from Aluno a where a.nome = :nome";
//        Aluno alunoJPQL = entityManager
//                .createQuery(jpql, Aluno.class)
//                .setParameter("nome", nome)
//                .getSingleResult();

//        String jpqlList = "select a from Aluno a where a.estado = :estado";
//        List<Aluno> alunoJPQLList = entityManager
//                .createQuery(jpqlList, Aluno.class)
//                .setParameter("estado", estadoAdd)
//                .getResultList();

//        System.out.println("Consulta alunoJPQL: " + alunoJPQL);
//        alunoJPQLList.forEach(Aluno -> System.out.println("Consulta alunoJPQLList: " + Aluno));

//        CriteriaQuery<Aluno> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Aluno.class);
//        Root<Aluno> alunoRoot = criteriaQuery.from(Aluno.class);
//        CriteriaBuilder.In<String> inClause = entityManager.getCriteriaBuilder().in(alunoRoot.get(Aluno_.nome));
//        inClause.value(nome);
//        criteriaQuery.select(alunoRoot).where(inClause);
//        Aluno alunoAPICriteria = entityManager.createQuery(criteriaQuery).getSingleResult();

//        CriteriaQuery<Aluno> criteriaQueryList = entityManager.getCriteriaBuilder().createQuery(Aluno.class);
//        Root<Aluno> alunoRootList = criteriaQueryList.from(Aluno.class);
//        List<Aluno> alunoAPICriteriaList = entityManager.createQuery(criteriaQueryList).getResultList();

//        System.out.println("Consulta alunoAPICriteria: " + alunoAPICriteria);
//        alunoAPICriteriaList.forEach(Aluno -> System.out.println("Consulta alunoAPICriteriaList: " + Aluno));
    }
}
