import java.util.Scanner;
public class ppj4x{
  public static void main(String[] args){
    Scanner take = new Scanner(System.in);
    String prawda = "Zainicjowales poprawnie", falsz = "Zainicjowales niepoprawnie";
    char typ, typto, rzad1, rzad0;
    int d=0, drow[] = new int[9];
    char hrow[] = new char[8];
    boolean v = false;
    for (int i=0;i<8;i++){
      drow[i]=0;
      hrow[i]=0;
    }
      // wybor pierwotnego typu//
    do{
      System.out.println("\nProszę wybrać typ liczby\n\nb - binarny\nd - decymalny\nh - heksadecymalny\n");
      typ = take.next().charAt(0);System.out.print("\n");
      switch (typ) {
        case 'b':{
          System.out.println("Zmienna jest w typu binarnego\n");
          break;
        }
        case 'd':{
          System.out.println("Zmienna jest w typu decymalnego\n");
          break;
        }
        case 'h':{
          System.out.println("Zmienna jest w typu heksadecymalnego\n");
          break;
        }
        default:
          System.out.println("Error");
          break;
      }
    }while (typ != 'b' && typ != 'd' && typ != 'h');
    do{
      System.out.println("Prosze zainicjowac rzedy liczby.\nPierwsza to rzad \"dziesiatek\".\nDruga to rzad \"jednosci\".\n");
      System.out.print("("+typ+")");
      rzad1 = take.next().charAt(0);
      System.out.print("("+typ+")");
      rzad0 = take.next().charAt(0);
      System.out.print("\n");
        // sprawdzenie czy wartosci zgadzaja sie z typem //
      switch (typ){
        case 'b' :{
          if((rzad0 > 47 && rzad0 < 50) && (rzad1 > 47 && rzad1 < 50)){
            v = true;
          }
          System.out.println((v==true) ? prawda+"\nTwoja liczba to ("+typ+")"+rzad1+""+rzad0+"\n" : falsz+"\n");
          break;
        }
        case 'd' :{
          if  ((rzad0 > 47 && rzad0 < 58) && (rzad1 > 47 && rzad1 < 58)){
            v = true;
          }
          System.out.println((v==true) ? prawda+"\nTwoja liczba to ("+typ+")"+rzad1+""+rzad0+"\n" : falsz+"\n");
          break;
        }
        case 'h' :{
          if (((rzad0 > 47 && rzad0 < 58) || (rzad0 > 64 && rzad0 < 71) || (rzad0 > 96 && rzad0 < 103)) && ((rzad1 > 47 && rzad1 < 58) || (rzad1 > 64 && rzad1 < 71) || (rzad1 > 96 && rzad1 < 103))){
            v = true;
          }
          System.out.println((v==true) ? prawda+"\nTwoja liczba to ("+typ+")"+rzad1+""+rzad0+"\n" : falsz+"\n");
          break;
        }
      }
    }while(v==false);
      // wybor zmiany typu i zmiana typu wartosci //
    System.out.println("Prosze wybrac na jaki typ chcesz zmienic swoja zmienna: ");
    switch (typ){
      case 'b':{
        do{
          System.out.println("\nd - decymalny\nh - heksadecymalny\n");
          typto = take.next().charAt(0);
          switch (typto){
            case 'd':{
              System.out.printf("\n("+typ+")"+rzad1+rzad0+" = ("+typto+")");
              if (rzad0=='0' && rzad1=='0'){
                drow[0] = 0;
              }else if (rzad0=='0' && rzad1=='1'){
                drow[0] = 2;
              }else if (rzad0=='1' && rzad1=='0'){
                drow[0] = 1;
              }else if (rzad0=='1' && rzad1=='1'){
                drow[0] = 3;
              }
              break;
            }
            case 'h':{
              System.out.printf("\n("+typ+")"+rzad1+rzad0+" = ("+typto+")");
              if (rzad0=='0' && rzad1=='0'){
                drow[0] = 0;
              }else if (rzad0=='0' && rzad1=='1'){
                drow[0] = 2;
              }else if (rzad0=='1' && rzad1=='0'){
                drow[0] = 1;
              }else if (rzad0=='1' && rzad1=='1'){
                drow[0] = 3;
              }
              break;
            }
            default:{
              System.out.println("Error.");
            }
          }
        }while(typto != 'd' && typto != 'h');
        System.out.printf("%d\n\n",drow[0]);
        break;
        }
      case 'd':{
        d=(rzad1-48)*10+(rzad0-48);
        do{
          System.out.println("\nb - binarny\nh - heksadecymalny\n");
          typto = take.next().charAt(0);
          switch (typto){
            case 'b':{
              System.out.print("\n("+typ+")"+rzad1+rzad0+" = ("+typto+")");
              for(int i=7, n=64; i!=0; i--){
                if (d>=n){
                  drow[i]=1;
                  d=d-n;
                }
                n=n/2;
                System.out.printf("%d",drow[i]);
                }
              System.out.print("\n\n");
              break;
              }
            case 'h':{
              System.out.print("\n("+typ+")"+rzad1+rzad0+" = ("+typto+")");
              if (d%16<10){
                hrow[0]=(char)((d%16)+48);
              }else if (d%16>=10){
                hrow[0]=(char)((d%16)+55);
              }
              if ((d-(d%16))/16<10){
                hrow[1]=(char)(((d-(d%16))/16)+48);
              }else if ((d-(d%16))/16>=10){
                hrow[1]=(char)(((d-(d%16))/16)+55);
              }
              if(hrow[1]=='0'){
                System.out.printf("%c\n\n", hrow[0]);
              } else if(hrow[1]!='0'){
                System.out.printf("%c%c\n\n", hrow[1], hrow[0]);
              }
              break;
            }
            default:{
              System.out.println("Error.");
            }
          }
        }while(typto != 'b' && typto != 'h');
        break;
      }
      case 'h':{
        do{
          System.out.println("\nb - binarny\nd - decymalny\n");
          typto = take.next().charAt(0);
          //hehe//
          {
            if (rzad1<58 && rzad0<58){
              d=(rzad1-48)*16+(rzad0-48);
            }else if (rzad1>64 && rzad1<71 && rzad0<58){
              d=(rzad1-55)*16+(rzad0-48);
            }else if (rzad1>96 && rzad0<58){
              d=(rzad1-87)*16+(rzad0-48);
            }else if (rzad1<58 && rzad0>64 && rzad0<71){
              d=(rzad1-48)*16+(rzad0-55);
            }else if (rzad1>64 && rzad1<71 && rzad0>64 && rzad0<71){
              d=(rzad1-55)*16+(rzad0-55);
            }else if (rzad1>96 && rzad0>64 && rzad0<71){
              d=(rzad1-87)*16+(rzad0-55);
            }else if (rzad1<58 &&  rzad0>96){
              d=(rzad1-48)*16+(rzad0-87);
            }else if (rzad1>64 && rzad1<71 && rzad0>96){
              d=(rzad1-55)*16+(rzad0-87);
            }else if (rzad1>96 &&  rzad0>96){
              d=(rzad1-87)*16+(rzad0-87);
            }
          }
          switch (typto){
            case 'b':{
              System.out.printf("\n("+typ+")"+rzad1+rzad0+" = ("+typto+")");
              for(int i=8, n=128; i!=0; i--){
                if (d>=n){
                  drow[i]=1;
                  d=d-n;
                }
                n=n/2;
                System.out.printf("%d",drow[i]);
                }
              System.out.println("\n");
              break;
              }
            case 'd':{
              System.out.printf("\n("+typ+")"+rzad1+rzad0+" = ("+typto+")%d\n\n",d);
              break;
              }
            default:{
              System.out.println("Error.");
              break;
            }
          }
        }while(typto != 'b' && typto != 'd');
        break;
        }
    }
  }
}
