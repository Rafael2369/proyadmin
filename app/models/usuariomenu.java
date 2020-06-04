package models;
import javax.persistence.*;

@Entity
public class usuariomenu{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long MEN_ID;
   Long MEN_IDAPPLICATION;
   Long MEN_NUMORDER;
   Long MEN_ID_PADRE;
   Long MEN_IDUSUSARIO;

   public Long getMEN_ID() {
      return MEN_ID;
   }

   public void setMEN_ID(Long MEN_ID) {
      this.MEN_ID = MEN_ID;
   }

   public Long getMEN_IDAPPLICATION() {
      return MEN_IDAPPLICATION;
   }

   public void setMEN_IDAPPLICATION(Long MEN_IDAPPLICATION) {
      this.MEN_IDAPPLICATION = MEN_IDAPPLICATION;
   }

   public Long getMEN_NUMORDER() {
      return MEN_NUMORDER;
   }

   public void setMEN_NUMORDER(Long MEN_NUMORDER) {
      this.MEN_NUMORDER = MEN_NUMORDER;
   }

   public Long getMEN_ID_PADRE() {
      return MEN_ID_PADRE;
   }

   public void setMEN_ID_PADRE(Long MEN_ID_PADRE) {
      this.MEN_ID_PADRE = MEN_ID_PADRE;
   }

   public Long getMEN_IDUSUSARIO() {
      return MEN_IDUSUSARIO;
   }

   public void setMEN_IDUSUSARIO(Long MEN_IDUSUSARIO) {
      this.MEN_IDUSUSARIO = MEN_IDUSUSARIO;
   }

}
