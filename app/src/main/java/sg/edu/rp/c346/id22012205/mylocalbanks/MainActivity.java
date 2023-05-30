package sg.edu.rp.c346.id22012205.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView TvDBS;
    TextView TvOCBC;
    TextView TvUOB;
    TextView Bank;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TvDBS = findViewById(R.id.textViewDBS);
        TvOCBC = findViewById(R.id.textViewOCBC);
        TvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(TvDBS);
        registerForContextMenu(TvOCBC);
        registerForContextMenu(TvUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            TvDBS.setText(R.string.DBS);
            TvOCBC.setText(R.string.OCBC);
            TvUOB.setText(R.string.UOB);
            return true;
        } else if (id == R.id.chineseSelection) {
            TvDBS.setText(R.string.chinesedbs);
            TvOCBC.setText(R.string.chineseOCBC);
            TvUOB.setText(R.string.chineseUOB);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == TvDBS) {
            wordClicked = "DBS";
        } else if (v == TvOCBC) {
            wordClicked = "OCBC";
        } else if (v == TvUOB) {
            wordClicked = "UOB";
        }
        menu.add(0, 0, 0, R.string.web);
        menu.add(0, 1, 1, R.string.C);
        menu.add(0,2,2,R.string.TF);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent link1 = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.DBS_web)));
                startActivity(link1);
                return true;
            } else if (item.getItemId() ==1) {
                Intent Call1=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.DBS_HP)));
                startActivity(Call1);
                return true;
            } else if (item.getItemId()==2) {
                if(TvDBS.getCurrentTextColor()==getResources().getColor(R.color.black)){
                    TvDBS.setTextColor(getResources().getColor(R.color.red));
                } else if ((TvDBS.getCurrentTextColor()==getResources().getColor(R.color.red))) {
                    TvDBS.setTextColor(getResources().getColor(R.color.black));
                }
                return true;
            }
        }  else if(wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent link2 = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.OCBC_WEB)));
                startActivity(link2);
                return true;
            } else if (item.getItemId() ==1) {
                Intent Call2=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.OCBC_HP)));
                startActivity(Call2);
                return true;
            }else if (item.getItemId()==2) {
                if(TvOCBC.getCurrentTextColor()==getResources().getColor(R.color.black)){
                    TvOCBC.setTextColor(getResources().getColor(R.color.red));
                } else if ((TvOCBC.getCurrentTextColor()==getResources().getColor(R.color.red))) {
                    TvOCBC.setTextColor(getResources().getColor(R.color.black));
                }
                return true;
            }
        }else if(wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent link3 = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.UOB_WEB)));
                startActivity(link3);
                return true;
            } else if (item.getItemId() ==1) {
                Intent Call3=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.UOB_HP)));
                startActivity(Call3);
                return true;
            }else if (item.getItemId()==2) {
                if(TvUOB.getCurrentTextColor()==getResources().getColor(R.color.black)){
                    TvUOB.setTextColor(getResources().getColor(R.color.red));
                } else if ((TvUOB.getCurrentTextColor()==getResources().getColor(R.color.red))) {
                    TvUOB.setTextColor(getResources().getColor(R.color.black));
                }
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }
}