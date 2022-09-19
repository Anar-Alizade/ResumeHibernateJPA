package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Country {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "nationality")
    private String nationality;

    @OneToMany(mappedBy = "nationalityId")
    private List<User> userList;

    @OneToMany(mappedBy = "birthplaceId")
    private List<User> userList1;

    public Country() {

    }

    public Country(int id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    public Country(int id, String name, String nationality, List<User> userList, List<User> userList1) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.userList = userList;
        this.userList1 = userList1;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        if (nationality != null ? !nationality.equals(country.nationality) : country.nationality != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        return result;
    }
}
