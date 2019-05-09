package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-05-05T20:18:59")
@StaticMetamodel(Reward.class)
public class Reward_ { 

    public static volatile SingularAttribute<Reward, Float> bonusMoney;
    public static volatile SingularAttribute<Reward, String> name;
    public static volatile SingularAttribute<Reward, String> description;
    public static volatile SingularAttribute<Reward, Integer> staffSalaryID;
    public static volatile SingularAttribute<Reward, Integer> id;
    public static volatile SingularAttribute<Reward, Date> day;

}