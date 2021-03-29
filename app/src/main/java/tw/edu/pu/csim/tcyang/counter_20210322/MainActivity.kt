package tw.edu.pu.csim.tcyang.counter_20210322

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var counter:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txv.setOnClickListener(this)
        img.setOnClickListener(this)
        //btn4.setOnClickListener(this)

        btn4.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                counter= (1..100).random()
                txv.text = counter.toString()
            }

        })

        txv.setOnLongClickListener(object:View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                counter+=2
                txv.text = counter.toString()
                return true
            }
        })


        txvvb.setOnTouchListener(object:View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                //txvvb.text="觸控測試"
                if (event?.action == MotionEvent.ACTION_DOWN){
                    txvvb.text="手指壓下"
                }
                else if (event?.action == MotionEvent.ACTION_UP){
                    txvvb.text="手指彈開"
                }
                return true
            }
        })
    }



    fun Add(v:View){
        if (v == btn1){
            counter++
        }
        else if(v==btn2){
            counter+=2
        }
        else{
            counter=0
        }

        txv.text = counter.toString()
    }

    override fun onClick(v: View?) {
        if (v == txv){
            counter++
        }
        else if (v == img){
            counter+=2
        }
        /*
        else{
            counter= (1..100).random()
            txv.text = counter.toString()
        }

         */
        txv.text = counter.toString()
    }


}