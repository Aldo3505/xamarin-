using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;

namespace PhilAPPines
{
    [Activity(Label = "CARINFO")]
    public class CARINFO : Activity
    {
        ImageButton Sun;
        TextView title, trivia1, trivia2, trivia3, trivia4, trivia5, trivia6, trivia7, trivia8, trivia9, trivia10, trivia11;

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            SetContentView(Resource.Layout.CARINFO);
            Sun = FindViewById<ImageButton>(Resource.Id.imageButton1);
            title = FindViewById<TextView>(Resource.Id.textView1);
            trivia1 = FindViewById<TextView>(Resource.Id.textView2);
            trivia2 = FindViewById<TextView>(Resource.Id.textView3);
            trivia3 = FindViewById<TextView>(Resource.Id.textView4);
            trivia4 = FindViewById<TextView>(Resource.Id.textView5);
            trivia5 = FindViewById<TextView>(Resource.Id.textView6);
            trivia6 = FindViewById<TextView>(Resource.Id.textView7);
            trivia7 = FindViewById<TextView>(Resource.Id.textView8);
            trivia8 = FindViewById<TextView>(Resource.Id.textView9);
            trivia9 = FindViewById<TextView>(Resource.Id.textView10);
            trivia10 = FindViewById<TextView>(Resource.Id.textView12);
            trivia11 = FindViewById<TextView>(Resource.Id.textView13);
            //textview11 does not exist, Im not sure where my properties are
            Sun.Click += Sun_Click;
        }

        private void Sun_Click(object sender, EventArgs e)
        {
            Intent HomePage = new Intent(this, typeof(MainActivity));
            StartActivity(HomePage);
        }
    }
}