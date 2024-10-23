package com.example.pleasefuckingwork

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.pleasefuckingwork.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val webView = findViewById<WebView>(R.id.web)



        // loading http://www.google.com url in the WebView.
        webView.loadUrl(intent.extras?.getString("URL")!!)

        // this will enable the javascript.
        webView.settings.javaScriptEnabled = true

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView.webViewClient = WebViewClient()

//        val navController = findNavController(R.id.nav_host_fragment_content_article)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_article)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}