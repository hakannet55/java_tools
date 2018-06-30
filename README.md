# java_tools
java simplified tools

Samples..

# // empty(String) return;
if (t.empty(temp1) == false) {

# // Modal open-dialog
modal_hata("internet-problemi").show();

# // easy log print
t.print("cause you feel like paradise and need overcasion");

# // Goto another page swicth
t.go_to(getApplicationContext(),login_activity.class);


# easy-Layout textview add
   LinearLayout g1;
   TextView gtx;
   
   g1 = t.add_linear(ct, "m", "w");
   
   gtx = t.add_text(ct, "ttttxxx", "w", "w");
   
   g1.addView(gtx);
   
   lay.addView(g1);
   
      
 show hide;
 
   t.hide(v.getContext(),R.id.LinearLayout1 );
   
   t.show(v.getContext(),R.id.LinearLayout2 );
   
   #easy table row functions
                   tr=new TableRow(ct);
                   
                tr.setGravity(Gravity.CENTER_VERTICAL);
                
                prm=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
                
                tr.setLayoutParams(prm);
                
                t.ad_celltext(tr,ct,s1,10,align,border,txcolor);
                
                t.ad_celltext(tr,ct,snf,10,align,border,txcolor);
                
                t.ad_celltext(tr,ct,s2,10,align,border,txcolor);
                
                table.addView(tr);
                
