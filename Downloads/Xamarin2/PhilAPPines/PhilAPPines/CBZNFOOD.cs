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
    [Activity(Label = "CBZNFOOD")]
    public class CBZNFOOD : Activity
    {
        ImageButton Sun;
        TextView description, food1, food2;
        ImageView foodpic1, foodpic2;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            SetContentView(Resource.Layout.CBZNFOOD);
            Sun = FindViewById<ImageButton>(Resource.Id.imageButton1);
            description = FindViewById<TextView>(Resource.Id.textView1);
            food1 = FindViewById<TextView>(Resource.Id.textView2);
            food2 = FindViewById<TextView>(Resource.Id.textView3);
            foodpic1 = FindViewById<ImageView>(Resource.Id.imageView1);
            foodpic2 = FindViewById<ImageView>(Resource.Id.imageView2);
            Sun.Click += Sun_Click;
        }

        private void Sun_Click(object sender, EventArgs e)
        {
            Intent HomePage = new Intent(this, typeof(MainActivity));
            StartActivity(HomePage);
        }
    }
}