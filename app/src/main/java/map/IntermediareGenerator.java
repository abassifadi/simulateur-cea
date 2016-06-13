package map;

import android.location.Location;

import java.util.Vector;

/**
 * Created by Fadi on 6/2/2016.
 */
public class IntermediareGenerator {


      private Vector<Intermediare> intermedaires ;

        public IntermediareGenerator(){

            setIntermedaires(new Vector<Intermediare>());
            //Intermediare 1
            Intermediare in1=new Intermediare();
            in1.setNom("AMEN-INVEST");
            in1.setLatitude(36.831954);
            in1.setLongitude(10.228966);
            getIntermedaires().add(in1);
            //Intermediare 2
            Intermediare in2=new Intermediare();
            in2.setNom("AFC");
            in2.setLatitude(36.844142);
            in2.setLongitude(10.270352);
            getIntermedaires().add(in2);
            //Intermediaire 3
            Intermediare in3=new Intermediare();
            in3.setNom("BEST-INVEST ");
            in3.setLatitude(36.819411);
            in3.setLongitude(10.191460);
            getIntermedaires().add(in3);
            //intermediare 4
            Intermediare in4=new Intermediare();
            in4.setNom("BNA-Capitaux");
            in4.setLatitude(36.734115);
            in4.setLongitude(9.192032);
            getIntermedaires().add(in3);

            Intermediare in5=new Intermediare();
            in5.setNom("COFIB-CAPITAL FINANCES");
            in5.setLatitude(36.832415);
            in5.setLongitude(10.177715);
            getIntermedaires().add(in5);

            Intermediare in6=new Intermediare();
            in6.setNom("CGF");
            in6.setLatitude(36.884480);
            in6.setLongitude(10.333524);
            getIntermedaires().add(in6);


            Intermediare in7=new Intermediare();
            in7.setNom("CGI");
            in7.setLatitude(36.801595);
            in7.setLongitude(10.183843);
            getIntermedaires().add(in7);

            Intermediare in8=new Intermediare();
            in8.setNom("BIAT CAPITAL");
            in8.setLatitude(36.833971);
            in8.setLongitude(10.235524);
            getIntermedaires().add(in8);

            Intermediare in9=new Intermediare();
            in9.setNom("QAFF");
            in9.setLatitude(36.832804);
            in9.setLongitude(10.236401);
            getIntermedaires().add(in9);


            Intermediare in10=new Intermediare();
            in10.setNom("MAC SA");
            in10.setLatitude(36.831933);
            in10.setLongitude(10.230532);
            getIntermedaires().add(in10);


            Intermediare in11=new Intermediare();
            in11.setNom("Maxula Bourse");
            in11.setLatitude(36.840041);
            in11.setLongitude(10.242622);
            getIntermedaires().add(in11);


            Intermediare in12=new Intermediare();
            in12.setNom("SIFIB-BH ");
            in12.setLatitude(36.847340);
            in12.setLongitude(10.200252);
            getIntermedaires().add(in12);


            Intermediare in13=new Intermediare();
            in13.setNom("SBT");
            in13.setLatitude(36.799872);
            in13.setLongitude(10.185791);
            getIntermedaires().add(in13);

            Intermediare in14=new Intermediare();
            in14.setNom("SCIF");
            in14.setLatitude(36.835281);
            in14.setLongitude(10.231267);
            getIntermedaires().add(in14);

            Intermediare in15=new Intermediare();
            in15.setNom("STB Finance");
            in15.setLatitude(36.847455);
            in15.setLongitude(10.192437);
            getIntermedaires().add(in15);

            Intermediare in16=new Intermediare();
            in16.setNom("MCP");
            in16.setLatitude(36.835543);
            in16.setLongitude(10.239677);
            getIntermedaires().add(in15);

            Intermediare in17=new Intermediare();
            in17.setNom("Attijari Intermediation");
            in17.setLatitude(36.835543);
            in17.setLongitude(10.229677);
            getIntermedaires().add(in17);

            Intermediare in18=new Intermediare();
            in18.setNom("Tunisie Valeurs");
            in18.setLatitude(36.844896);
            in18.setLongitude(10.197958);
            getIntermedaires().add(in18);

            Intermediare in19=new Intermediare();
            in19.setNom("TSI");
            in19.setLatitude(36.843490);
            in19.setLongitude(10.197843);
            getIntermedaires().add(in19);

            Intermediare in20=new Intermediare();
            in20.setNom("UBCI Finance");
            in20.setLatitude(36.816011);
            in20.setLongitude(10.180077);
            getIntermedaires().add(in20);

            Intermediare in21=new Intermediare();
            in21.setNom("UFI");
            in21.setLatitude(36.851129);
            in21.setLongitude(10.207876);
            getIntermedaires().add(in21);

            Intermediare in22=new Intermediare();
            in22.setNom("FINACORP");
            in22.setLatitude(36.834680);
            in22.setLongitude(10.242570);
            getIntermedaires().add(in22);

            Intermediare in23=new Intermediare();
            in23.setNom("Axis Capital Bourse");
            in23.setLatitude(36.811606);
            in23.setLongitude(10.184554);
            getIntermedaires().add(in23);

        }


    public Vector<Intermediare> getIntermedaires() {
        return intermedaires;
    }

    public void setIntermedaires(Vector<Intermediare> intermedaires) {
        this.intermedaires = intermedaires;
    }

    public Intermediare getNearestIntermediare(Location loc) {

          Intermediare i = new Intermediare() ;
          return i;
    }
}
