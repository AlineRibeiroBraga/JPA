import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bancodedados");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("---------------------------------------------");
        final TeamDAO teamDAO = new TeamDAO(entityManager);

        Team team1 = new Team("invillia");
        /*teamDAO.inserir(team1);

        System.out.println(teamDAO.buscarTudo());*/

        final MemberDAO memberDAO = new MemberDAO(entityManager);


        Member member= new Member("Aline",team1);
        //memberDAO.inserir(member);
        teamDAO.deletarId(1L);
    }
}

