package mn.turuu.springtest.model;
// Generated May 28, 2017 1:21:27 PM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.standard.StandardFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product")
@Indexed
@AnalyzerDef(name = "ProductTextAnalyzer", tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
            @TokenFilterDef(factory = LowerCaseFilterFactory.class),
            @TokenFilterDef(factory = StandardFilterFactory.class)
        })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements java.io.Serializable {

    private Integer id;
    private String name;
    private double price;

    @JsonIgnore
    private Set<Basket> baskets = new HashSet<>(0);

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price, Set<Basket> baskets) {
        this.name = name;
        this.price = price;
        this.baskets = baskets;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store=Store.NO, analyzer = @Analyzer(definition = "ProductTextAnalyzer"))
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price", nullable = false, precision = 22, scale = 0)
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public Set<Basket> getBaskets() {
        return this.baskets;
    }

    public void setBaskets(Set<Basket> baskets) {
        this.baskets = baskets;
    }
}
