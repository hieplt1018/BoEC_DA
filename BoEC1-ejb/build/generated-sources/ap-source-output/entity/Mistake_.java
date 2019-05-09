package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-05-05T20:18:59")
@StaticMetamodel(Mistake.class)
public class Mistake_ { 

    public static volatile SingularAttribute<Mistake, String> reason;
    public static volatile SingularAttribute<Mistake, String> name;
    public static volatile SingularAttribute<Mistake, Integer> staffSalaryID;
    public static volatile SingularAttribute<Mistake, Integer> id;
    public static volatile SingularAttribute<Mistake, Float> penaltyMoney;
    public static volatile SingularAttribute<Mistake, Date> day;

}