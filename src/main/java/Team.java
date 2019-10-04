import javax.persistence.*;

@Entity
@Table(name = "times")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_time;

    @Column(name = "nome_time", nullable = false)
    private String name;

    public Team() {
    }

    public Team(String name){
        this.name = name;
    }

    public Long getIdTime() {
        return id_time;
    }

    public void setIdTime(long id_time) {
        this.id_time = id_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team " + id_time + ", " + name;
    }
}
