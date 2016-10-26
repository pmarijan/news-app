package si.primoz.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author primoz
 */
@Entity
@Table(name = "news")
public class News {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @NotEmpty(message = "error.news.title.not.empt")
    @NotNull(message = "error.news.title.not.null")
    @Column(name = "title", nullable = false)
    private String title;
    
    @NotEmpty(message = "error.news.text.not.empt")
    @NotNull(message = "error.news.text.not.null")
    @Column(name = "text", nullable = false)
    private String text;
    
    @NotNull(message = "error.news.date.not.null")
    @Column(name = "date", nullable = false)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date = new Date();
    
    @NotNull(message = "error.news.category.not.null")
    @ManyToOne(optional = false, targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    protected News() {
    }
    
    public News(Integer id, String title, String text, Category category) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.category = category;
    }
    
    public News(Integer id, String title, String text, Date date, Category category) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "News{" + "id=" + id + ", title=" + title + ", text=" + text + ", date=" + date + ", category=" + category + '}';
    }
}
