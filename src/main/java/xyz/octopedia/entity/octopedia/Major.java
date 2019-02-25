package xyz.octopedia.entity.octopedia;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_major")
public class Major {
    /**
     * ID
     */
    @Id
    @Column(columnDefinition = "INT(11) UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 专业名
     */
    @Column(nullable = false)
    private String name;

    /**
     * 父ID 无父节点为 -1
     */
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private Integer parentId;

}
