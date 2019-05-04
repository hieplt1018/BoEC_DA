package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-05-04T07:33:53")
@StaticMetamodel(ShiftTime.class)
public class ShiftTime_ { 

    public static volatile SingularAttribute<ShiftTime, Date> starTime;
    public static volatile SingularAttribute<ShiftTime, Date> finishTime;
    public static volatile SingularAttribute<ShiftTime, Integer> id;
    public static volatile SingularAttribute<ShiftTime, Date> day;

}