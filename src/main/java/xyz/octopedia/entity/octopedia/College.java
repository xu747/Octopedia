package xyz.octopedia.entity.octopedia;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "t_college")
public class College {
    /**
     * ID
     */
    @Id
    @Column(columnDefinition = "INT(11) UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 大学名称
     */
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private int size;

    @Column(nullable = false)
    private int gender;

    @Column(nullable = false)
    private int privateType;

    @Column(nullable = false)
    private int entranceDifficulty;

    @Column(nullable = false)
    private int freshmanSatisfaction;

    @Column(nullable = false)
    private int graduationRate;

    @Column(nullable = false)
    private int costOfAttendance;

    @Column(nullable = false)
    private int financialNeedMet;

    @Column(nullable = false)
    private int studentDebt;

    @Column(nullable = false)
    private int meritAid;

    @ElementCollection
    private List<String> Sports;

    @Column(nullable = false)
    private int americanIndianOrAlaskanNativeStudent;

    @Column(nullable = false)
    private int africanAmericanStudent;

    @Column(nullable = false)
    private int asianOrPacificIslanderStudent;

    @Column(nullable = false)
    private int hispanicStudent;

    @Column(nullable = false)
    private int internationalStudent;

    @ElementCollection
    private List<Major> majors;
}
