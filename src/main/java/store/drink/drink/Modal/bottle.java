package store.drink.drink.Modal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class bottle {
    @Id
    private String id;
    @NotNull(message = "Name can have only  letters and digits")
    @NotEmpty(message = "This field cannot be empty")
    private String name;
    //@Pattern(regexp = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)")
    private String bottlePic;
    //@NotNull(message = "Value must be greater than Zero")
    private double volume;
    private boolean isAlcoholic;
    private double volumePercent;
    //@NotNull(message = "Value must be greater than Zero")
    private int price;
    //@NotNull(message = "Name can have only  letters and digits")
    // @NotEmpty(message = "This field cannot be empty")
    private String supplier;
    //@NotNull(message = "Value must be greater than or equal to Zero")
    private int inStock;


}


