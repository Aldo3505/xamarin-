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
    [Activity(Label = "PhilAPPines", MainLauncher = true, Icon = "@drawable/icon", Theme = "@android:style/Theme.Custom")]
    public class MainActivity : Activity
    {
        protected override void OnCreate(Bundle bundle)
        {
            SetContentView(Resource.Layout.Main);
            //VectorMap = FindViewById<ImageView>(Resource.Drawable.vectormap);
            //imageView.SetImageResource(Resource.Drawable.vectormap);
        
            //SunLogo = FindViewById<ImageView>(Resource.Id.imageView1);;
            //Button button = FindViewById<Button>(Resource.Id.Button);
            //button.Click += delegate;
    
}


    }
}