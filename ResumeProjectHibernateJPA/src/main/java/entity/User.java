package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class User {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "profile_description")
    private String profileDescription;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "birthdate")
    private Date birthdate;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<UserSkill> userSkillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<EmploymentHistory> employmentHistoryList;
    @JoinColumn(name = "nationality_id", referencedColumnName = "id")
    @ManyToOne
    private Country nationalityId;
    @JoinColumn(name = "birthplace_id", referencedColumnName = "id")
    @ManyToOne
    private Country birthplaceId;

    public User() {

    }

    public User(int id, String name, String surname, String email, String phone, String profileDescription, String address, Date birthdate, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.profileDescription = profileDescription;
        this.address = address;
        this.birthdate = birthdate;
        this.password = password;
    }

    public User(int id, String name, String surname, String email, String phone, String profileDescription, String address, Date birthdate, String password, List<UserSkill> userSkillList, List<EmploymentHistory> employmentHistoryList, Country nationalityId, Country birthplaceId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.profileDescription = profileDescription;
        this.address = address;
        this.birthdate = birthdate;
        this.password = password;
        this.userSkillList = userSkillList;
        this.employmentHistoryList = employmentHistoryList;
        this.nationalityId = nationalityId;
        this.birthplaceId = birthplaceId;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Country getBirthplaceId() {
        return birthplaceId;
    }

    public void setBirthplaceId(Country birthplaceId) {
        this.birthplaceId = birthplaceId;
    }

    public Country getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Country nationalityId) {
        this.nationalityId = nationalityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (profileDescription != null ? !profileDescription.equals(user.profileDescription) : user.profileDescription != null)
            return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (birthdate != null ? !birthdate.equals(user.birthdate) : user.birthdate != null) return false;
        if (birthplaceId != null ? !birthplaceId.equals(user.birthplaceId) : user.birthplaceId != null) return false;
        if (nationalityId != null ? !nationalityId.equals(user.nationalityId) : user.nationalityId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (profileDescription != null ? profileDescription.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (birthplaceId != null ? birthplaceId.hashCode() : 0);
        result = 31 * result + (nationalityId != null ? nationalityId.hashCode() : 0);
        return result;
    }
}
