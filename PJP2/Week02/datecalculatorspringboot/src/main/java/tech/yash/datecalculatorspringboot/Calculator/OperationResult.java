package tech.yash.datecalculatorspringboot.Calculator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "date_operation")
@NamedStoredProcedureQuery(
        name = "perform_operation_sp",
        procedureName = "perform_operation",
        parameters = {
                @StoredProcedureParameter(name = "operation", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "arg1", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "arg2", mode = ParameterMode.IN, type = String.class)
        }
)
public class OperationResult implements Serializable {
    @Id
    @GeneratedValue
    private Integer uid;

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }
}