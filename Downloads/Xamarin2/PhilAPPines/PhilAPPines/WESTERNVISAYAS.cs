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
    [Activity(Label = "WESTERNVISAYAS")]
    public class WESTERNVISAYAS : Activity
    {
        ImageButton sun, info, food, people, sites;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            SetContentView(Resource.Layout.WVIS);
            sun = FindViewById<ImageButton>(Resource.Id.imageButton1);
            info = FindViewById<ImageButton>(Resource.Id.imageButton6);
            food = FindViewById<ImageButton>(Resource.Id.imageButton3);
            people = FindViewById<ImageButton>(Resource.Id.imageButton4);
            sites = FindViewById<ImageButton>(Resource.Id.imageButton5);
            sun.Click += Sun_Click;
            info.Click += Info_Click;
            food.Click += Food_Click;
            people.Click += People_Click;
            sites.Click += Sites_Click;
        }

        private void Sun_Click(object sender, EventArgs e)
        {
            Intent HomePage = new Intent(this, typeof(MainActivity));
            StartActivity(HomePage);
        }

        private void Sites_Click(object sender, EventArgs e)
        {
            Intent PLACES = new Intent(this, typeof(WVISAYASPLACES));
            StartActivity(PLACES);
        }

        private void People_Click(object sender, EventArgs e)
        {
            Intent PPL = new Intent(this, typeof(WVISAYASPPL));
            StartActivity(PPL);
        }

        private void Food_Click(object sender, EventArgs e)
        {
            Intent FOOD = new Intent(this, typeof(WVISAYASFOOD));
            StartActivity(FOOD);
        }

        private void Info_Click(object sender, EventArgs e)
        {
            Intent INFO = new Intent(this, typeof(WVISAYASINFO));
            StartActivity(INFO);
        }
    }
}