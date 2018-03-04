﻿using System;
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
    [Activity(Label = "NMINPLACES")]
    public class NMINPLACES : Activity
    {
        ImageButton Sun;
        TextView description, place1, place2;
        ImageView placepic1, placepic2;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            //Assuming only 2 places
            SetContentView(Resource.Layout.NMINPLACES);
            Sun = FindViewById<ImageButton>(Resource.Id.imageButton1);
            description = FindViewById<TextView>(Resource.Id.textView1);
            place1 = FindViewById<TextView>(Resource.Id.textView2);
            place2 = FindViewById<TextView>(Resource.Id.textView3);
            placepic1 = FindViewById<ImageView>(Resource.Id.imageView1);
            placepic2 = FindViewById<ImageView>(Resource.Id.imageView2);
            Sun.Click += Sun_Click;
        }

        private void Sun_Click(object sender, EventArgs e)
        {
            Intent HomePage = new Intent(this, typeof(MainActivity));
            StartActivity(HomePage);
        }
    }
}