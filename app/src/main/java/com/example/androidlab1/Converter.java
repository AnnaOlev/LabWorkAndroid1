package com.example.androidlab1;

public class Converter{

    private final static int DG_POWER = 6;

    private final static String[][] a_power = new String[][]{
            {"0", ""            , ""             ,""              },
            {"1", "тысяча "     , "тысячи "      ,"тысяч "        },
            {"0", "миллион "    , "миллиона "    ,"миллионов "    },
    };

    private final static String[][] digit = new String[][] {
            {""       ,""       , "десять "      , ""            ,""          },
            {"один "  ,"одна "  , "одиннадцать " , "десять "     ,"сто "      },
            {"два "   ,"две "   , "двенадцать "  , "двадцать "   ,"двести "   },
            {"три "   ,"три "   , "тринадцать "  , "тридцать "   ,"триста "   },
            {"четыре ","четыре ", "четырнадцать ", "сорок "      ,"четыреста "},
            {"пять "  ,"пять "  , "пятнадцать "  , "пятьдесят "  ,"пятьсот "  },
            {"шесть " ,"шесть " , "шестнадцать " , "шестьдесят " ,"шестьсот " },
            {"семь "  ,"семь "  , "семнадцать "  , "семьдесят "  ,"семьсот "  },
            {"восемь ","восемь ", "восемнадцать ", "восемьдесят ","восемьсот "},
            {"девять ","девять ", "девятнадцать ", "девяносто "  ,"девятьсот "}
    };

    private static String toString(int sum){
        int  i,mny;
        StringBuilder result = new StringBuilder("");
        long divisor;
        int psum = sum;

        int one  = 1;
        int four = 2;
        int many = 3;

        int hun  = 4;
        int dec  = 3;
        int dec2 = 2;

        for(i=0,divisor=1; i<DG_POWER; i++) divisor *= 1000;

        for(i=DG_POWER-1; i>=0; i--){
            divisor /= 1000;
            mny = (int)(psum / divisor);
            psum %= divisor;

            if(mny==0){
                if(i>0) continue;
                result.append( a_power[i][one] );
            }else{
                if(mny>=100){ result.append( digit[mny/100][hun]); mny%=100; }
                if(mny>=20 ){ result.append( digit[mny/10 ][dec]); mny%=10; }
                if(mny>=10 ){
                    result.append( digit[mny-10 ][dec2]);
                }else{
                    if(mny>=1  ) result.append( digit[mny][ "0".equals(a_power[i][0]) ? 0 : 1 ] );
                }
                switch(mny){
                    case  1: result.append( a_power[i][one] ); break;
                    case  2:
                    case  3:
                    case  4: result.append( a_power[i][four]); break;
                    default: result.append( a_power[i][many]); break;
                }
            }
        }
        return result.toString();
    }

    public static String toString(double num ){
        return toString( (int)num) + toString( (int)(num*100 - ((int)num)*100) );
    }

}