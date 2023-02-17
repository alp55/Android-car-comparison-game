package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random r=new Random();
    ImageView res1,res2,res3,next,gameoverback,gameovergif,nextcoin,coingif,restartimg;
    int a,b,c,tutucu1,tutucu2,t=1,skortut=0,haktut=5,leveltut=1,dogru=0,yanlis=0,dogruyanlis=0;
    Button ust,alt,nextbtn,coinbuton,restartbuton;
    TextView score,level,hak,sorutext;


    private   Integer[] araba = {

            R.drawable.araba,//mercedes g63 336 bg
            R.drawable.araba2,//porsche 911 355
            R.drawable.araba3,//612
            R.drawable.araba4,//510
            R.drawable.araba5,//
            R.drawable.araba6,//
            R.drawable.araba7,//
            R.drawable.araba8,//
            R.drawable.araba9,//
            R.drawable.araba10,//
            R.drawable.araba11,//
            R.drawable.araba12,//
            R.drawable.araba13,//
            R.drawable.araba14,//
            R.drawable.araba15,//
            R.drawable.araba16,//
            R.drawable.araba17,//
            R.drawable.araba18,//
            R.drawable.araba19,//
            R.drawable.araba20,//
            R.drawable.araba21,//
            R.drawable.araba22//

    };
    private   Integer[] hp = {

            336,
            355,
            612,
            510,
            571,
            986,
            95,
            600,
            300,
            400,
            537,
            420,
            789,
            450,
            631,
            473,
            500,
            1000,
            585,
            200,
            230,
            270,






    };

    private String[] soru={
            "Hangi aracın beygir gücü diğerinden fazladır ?",
            "Hangi aracın tork gücü diğerinden fazladır ?",
            "Hangi araç 0'dan 100'e daha önce ulaşır ?",
            "Hangi araç nürnburgring pistinde daha iyi performans sergilemiştir ?",
            "Hangi aracın toplam hızı diğerinden fazladır?",


    };

    private   Integer[] winlose = {
            R.drawable.win,
            R.drawable.lose,
            R.drawable.bos,
    } ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res1=(ImageView) findViewById(R.id.ustresim);
        res2=(ImageView) findViewById(R.id.altresim);
        res3=(ImageView) findViewById(R.id.winorlose);
        ust=(Button) findViewById(R.id.ustbuton) ;
        alt=(Button )findViewById(R.id.altbuton);
        next=(ImageView)findViewById(R.id.nextimg);
        nextbtn=(Button)findViewById(R.id.nextbtn);
        score=(TextView)findViewById(R.id.textscore);
        hak=(TextView)findViewById(R.id.haktext) ;
        level=(TextView)findViewById(R.id.lvtext) ;
        gameoverback=(ImageView)findViewById(R.id.gameoverback);
        gameovergif=(ImageView)findViewById(R.id.gameovergif);
        nextcoin=(ImageView)findViewById((R.id.nextcoin));
        coingif=(ImageView)findViewById(R.id.coingif);
        restartimg=(ImageView)findViewById(R.id.restartimg) ;
        restartbuton=(Button)findViewById(R.id.restartbuton);
        coinbuton=(Button)findViewById(R.id.coinbuton);
        sorutext=(TextView) findViewById(R.id.soru);


        hak.setText(""+haktut);
        score.setText(""+skortut);
        level.setText(""+leveltut);
        c=r.nextInt(5);
        sorutext.setText(""+soru[c]);




        rasgale();


    }

    private void rasgale()

    {
        while(t==1)

        {
            a=r.nextInt(22);
            b=r.nextInt(22);
            if(a!=b)
            {
                res1.setImageResource(araba[a]);
                res2.setImageResource(araba[b]);
                tutucu1=Integer.parseInt(hp[a].toString());
                tutucu2=Integer.parseInt(hp[b].toString());
                break;
            }
            else
            {
                a=r.nextInt(22);
                b=r.nextInt(22);
            }

        }
    }

    private void gameover()
    {
        sorutext.setVisibility(View.INVISIBLE);
        gameoverback.setVisibility(View.VISIBLE);
        gameovergif.setVisibility(View.VISIBLE);
        nextcoin.setVisibility(View.VISIBLE);
        coingif.setVisibility(View.VISIBLE);
        restartimg.setVisibility(View.VISIBLE);
        restartbuton.setVisibility(View.VISIBLE);
        coinbuton.setVisibility(View.VISIBLE);


    }


    public void ust(View view) throws InterruptedException
    {

        if (tutucu1>tutucu2 )

        {
            dogru=dogru+1;
            if(dogru>=3)
            {
                dogruyanlis=dogruyanlis+1;
                level.setText(""+dogruyanlis);
                dogru=0;
            }


            sorutext.setVisibility(View.INVISIBLE);

            skortut=skortut+3;
            score.setText(""+skortut);
            res3.setImageResource(winlose[0]);

            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    res3.setImageResource(winlose[2]);

                }
            },2000);


        }
        else
        {
            sorutext.setVisibility(View.INVISIBLE);
            yanlis=yanlis+1;
            haktut=haktut-1;
            hak.setText(""+haktut);
            res3.setImageResource(winlose[1]);
               new Handler().postDelayed(new Runnable()
               {
                   @Override
                   public void run()
                   {
                       res3.setImageResource(winlose[2]);

                   }

               },2000);



        }
        ust.setVisibility(View.INVISIBLE);
        alt.setVisibility(View.INVISIBLE);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                next.setVisibility(View.VISIBLE);
                nextbtn.setVisibility(View.VISIBLE);
            }
        },2000);





    }

    public void alt(View view) throws InterruptedException {





         if (tutucu2>tutucu1 )

        {
            dogru=dogru+1;
            if(dogru>=3)
            {
                dogruyanlis=dogruyanlis+1;
                level.setText(""+dogruyanlis);
                dogru=0;
            }
            sorutext.setVisibility(View.INVISIBLE);
            dogru=dogru+1;
            skortut=skortut+3;
            score.setText(""+skortut);
            res3.setImageResource(winlose[0]);
            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    res3.setImageResource(winlose[2]);
                }
            },2000);





        }
        else
        {
            sorutext.setVisibility(View.INVISIBLE);
            haktut=haktut-1;
            hak.setText(""+haktut);


            res3.setImageResource(winlose[1]);
            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    res3.setImageResource(winlose[2]);

                }
            },2000);






        }

        ust.setVisibility(View.INVISIBLE);
        alt.setVisibility(View.INVISIBLE);
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                next.setVisibility(View.VISIBLE);
                nextbtn.setVisibility(View.VISIBLE);

            }
        },2000);







    }
    public void next(View view)
    {
        sorutext.setVisibility(View.VISIBLE);
        c=r.nextInt(5);
        sorutext.setText(""+soru[c]);

        rasgale();
        if(haktut==0)
        {
           gameover();

        }





        ust.setVisibility(View.VISIBLE);
        alt.setVisibility(View.VISIBLE);

        next.setVisibility(View.INVISIBLE);
        nextbtn.setVisibility(View.INVISIBLE);





    }
    public void devam(View view)
    {
        if (skortut>=20)
        {
            skortut=skortut-20;
            haktut=5;
            gameoverback.setVisibility(View.INVISIBLE);
            gameovergif.setVisibility(View.INVISIBLE);
            nextcoin.setVisibility(View.INVISIBLE);
            coingif.setVisibility(View.INVISIBLE);
            restartimg.setVisibility(View.INVISIBLE);
            restartbuton.setVisibility(View.INVISIBLE);
            coinbuton.setVisibility(View.INVISIBLE);
            sorutext.setVisibility(View.VISIBLE);

            hak.setText(""+haktut);
            score.setText(""+skortut);

        }




    }
    public void restart(View view)
    {
        haktut=5;
        skortut=0;
        leveltut=0;
        gameoverback.setVisibility(View.INVISIBLE);
        gameovergif.setVisibility(View.INVISIBLE);
        nextcoin.setVisibility(View.INVISIBLE);
        coingif.setVisibility(View.INVISIBLE);
        restartimg.setVisibility(View.INVISIBLE);
        restartbuton.setVisibility(View.INVISIBLE);
        coinbuton.setVisibility(View.INVISIBLE);
        sorutext.setVisibility(View.VISIBLE);

        hak.setText(""+haktut);
        level.setText(""+leveltut);
        score.setText(""+skortut);
        c=r.nextInt(5);
        sorutext.setText(""+soru[c]);

    }





}