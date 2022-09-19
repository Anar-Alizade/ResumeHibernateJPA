package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_skill", schema = "resume")
public class UserSkill {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "skill_id")
    private int skillId;
    @Basic
    @Column(name = "power")
    private int power;

    public UserSkill() {

    }

    public UserSkill(int id, int userId, int skillId, int power) {
        this.id = id;
        this.userId = userId;
        this.skillId = skillId;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSkill userSkill = (UserSkill) o;

        if (id != userSkill.id) return false;
        if (userId != userSkill.userId) return false;
        if (skillId != userSkill.skillId) return false;
        if (power != userSkill.power) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + skillId;
        result = 31 * result + power;
        return result;
    }
}
