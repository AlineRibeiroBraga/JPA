import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.Map;

public class MemberDAO {

    private final EntityManager EM;

    public MemberDAO(EntityManager EM) {
        this.EM = EM;
    }

    public void inserir(final Member member){
        EntityTransaction transaction = EM.getTransaction();

        transaction.begin();
        EM.persist(member);
        transaction.commit();
    }

    public List<Member> buscarTudo(){

        TypedQuery<Member> members = EM.createQuery("from membros", Member.class);
        return members.getResultList();
    }

    public Member buscarId(final Long id){
        return EM.find(Member.class,id);
    }

    public void update(final Member member) {
        final EntityTransaction transaction = EM.getTransaction();
        transaction.begin();
        EM.merge(member);
        transaction.commit();
    }

    public void deletarId(final Long id) {
        final EntityTransaction transaction = EM.getTransaction();

        transaction.begin();
        final Member member = buscarId(id);
        EM.remove(member);
        transaction.commit();
    }
}
