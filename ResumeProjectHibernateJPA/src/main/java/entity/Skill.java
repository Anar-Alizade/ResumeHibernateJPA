package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Skill {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skillId")
    private List<UserSkill> userSkillList;

    public Skill() {

    }

    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Skill(int id, String name, List<UserSkill> userSkillList) {
        this.id = id;
        this.name = name;
        this.userSkillList = userSkillList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skill skill = (Skill) o;

        if (id != skill.id) return false;
        if (name != null ? !name.equals(skill.name) : skill.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
