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
    [Activity(Label = "WVISAYASPPL")]
    public class WVISAYASPPL : Activity
    {
        ImageButton Sun;
        TextView description, pers1, pers2;
        ImageView perspic1, perspic2;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            //Assuming there are only 2 people
            SetContentView(Resource.Layout.WVISAYASPPL);
            Sun = FindViewById<ImageButton>(Resource.Id.imageButton1);
            description = FindViewById<TextView>(Resource.Id.textView1);
            pers1 = FindViewById<TextView>(Resource.Id.textView2);
            pers2 = FindViewById<TextView>(Resource.Id.textView3);
            perspic1 = FindViewById<ImageView>(Resource.Id.imageView1);
            perspic2 = FindViewById<ImageView>(Resource.Id.imageView2);
            Sun.Click += Sun_Click;
        }

        private void Sun_Click(object sender, EventArgs e)
        {
            Intent HomePage = new Intent(this, typeof(MainActivity));
            StartActivity(HomePage);
        }
    }
}