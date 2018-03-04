using System;
using Android.App;
using Android.Content;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Android.OS;
using System.Collections.Generic;
using System.Drawing;

namespace PhilAPPines
{
    [Activity(Label = "PhilAPPines", MainLauncher = true, Icon = "@drawable/icon", Theme = "@style/Theme.Custom")]
    public class MainActivity : Activity
    {
        ImageView VectorMap;
        ImageButton LZ, VS, MD;
  
        protected override void OnCreate(Bundle bundle)
        {
            base.OnCreate(bundle);
            SetContentView(Resource.Layout.Main);
            VectorMap = FindViewById<ImageView>(Resource.Drawable.vectormap);
            LZ = FindViewById<ImageButton>(Resource.Id.imageButton1);
            VS = FindViewById<ImageButton>(Resource.Id.imageButton2);
            MD = FindViewById<ImageButton>(Resource.Id.imageButton3);
            LZ.Click += LZ_Click;
            VS.Click += VS_Click;
            MD.Click += MD_Click;
        }

        private void MD_Click(object sender, EventArgs e)
        {
            Intent MD = new Intent(this, typeof(Mindanao));
            StartActivity(MD);
        }

        private void VS_Click(object sender, EventArgs e)
        {
            Intent VS = new Intent(this, typeof(Visayas));
            StartActivity(VS);
        }

        private void LZ_Click(object sender, EventArgs e)
        {
            Intent LZ = new Intent(this, typeof(Luzon));
            StartActivity(LZ);

        }
    }
}