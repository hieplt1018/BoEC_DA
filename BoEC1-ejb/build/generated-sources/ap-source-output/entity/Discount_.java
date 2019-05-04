package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-05-04T18:47:53")
@StaticMetamodel(Discount.class)
public class Discount_ { 

    public static volatile SingularAttribute<Discount, Date> beginDate;
    public static volatile SingularAttribute<Discount, Float> rate;
    public static volatile SingularAttribute<Discount, Date> endDate;
    public static volatile SingularAttribute<Discount, String> name;
    public static volatile SingularAttribute<Discount, Integer> id;

}