package xyz.octopedia.entity.octopedia;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_out_door_experience")
public class OutDoorExperience {
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
    private int outDoorType;

    /**
     * 时长
     */
    @Column(nullable = false)
    private int workMonth;
}
