package si.primoz.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String title;
    private String text;
    private Date date = new Date();
    private String category;

    //empty constructor should be there because of JPA
    protected News() {
    }
    
    public News(Integer id, String title, String text, String category) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.category = category;
    }
    
    public News(Integer id, String title, String text, Date date, String category) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "News{" + "id=" + id + ", title=" + title + ", text=" + text + ", date=" + date + ", category=" + category + '}';
    }
}
