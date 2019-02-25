package xyz.octopedia.entity.octopedia;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_reward")
public class Reward {
    /**
     * ID
     */
    @Id
    @Column(columnDefinition = "INT(11) UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类型
     */
    @Column(nullable = false)
    private int rewordType;

    /**
     * 级别
     */
    @Column(nullable = false)
    private int rewordLevel;

    /**
     * 登记
     */
    @Column(nullable = false)
    private int rewordGrade;
}
