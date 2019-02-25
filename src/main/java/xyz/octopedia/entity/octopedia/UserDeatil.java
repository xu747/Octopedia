package xyz.octopedia.entity.octopedia;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "t_user_detail")
public class UserDeatil {
    /**
     * ID
     */
    @Id
    @Column(columnDefinition = "INT(11) UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    @Column(nullable = false)
    private int userId;

    /**
     * 计划国家
     */
    @Column(nullable = false)
    private int planCountry;

    /**
     * 计划学历
     */
    @Column(nullable = false)
    private int planDiploma;

    /**
     * 计划入学时间
     */
    @Column(nullable = false)
    private int planDate;

    /**
     * 计划专业类型
     */
    @Column(nullable = false)
    private int planMajor;

    /**
     * 成绩
     */
    @Column(nullable = false)
    private int grade;

    /**
     * 成绩类型
     */
    @Column(nullable = false)
    private int gradeType;

    /**
     * 在读学校
     */
    @Column(nullable = false)
    private String nowSchoolName;

    /**
     * 当前年级
     */
    @Column(nullable = false)
    private int nowGrade;

    /**
     * 英语成绩种类
     */
    @Column(nullable = false)
    private int englishGradeType;

    /**
     * 英语成绩
     */
    @Column(nullable = false)
    private int englishGrade;

    /**
     * SAT or ACT
     */
    @Column(nullable = false)
    private int admissionType;

    /**
     * SAT or ACT 成绩
     */
    @Column(nullable = false)
    private int admissionGrade;

    /**
     * 工作经验
     */
    @ElementCollection
    private List<WorkExperience> workExperienceList;

    /**
     * 奖励
     */
    @ElementCollection
    private List<Reward> rewards;

    /**
     * 有专利
     */
    @Column(nullable = false)
    private boolean havePatent;

    /**
     * 论文种类
     */
    @Column(nullable = false)
    private int paperType;

    /**
     * 推荐信种类
     */
    @Column(nullable = false)
    private int recLetterType;




}
