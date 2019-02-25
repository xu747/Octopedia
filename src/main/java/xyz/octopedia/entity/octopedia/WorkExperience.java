package xyz.octopedia.entity.octopedia;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_work_experence")
public class WorkExperience {
    /**
     * ID
     */
    @Id
    @Column(columnDefinition = "INT(11) UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 工作类型
     */
    @Column(nullable = false)
    private int workType;

    /**
     * 企业类型
     */
    @Column(nullable = false)
    private int companyType;

    /**
     * 工作时长
     */
    @Column(nullable = false)
    private int workMonth;
}
