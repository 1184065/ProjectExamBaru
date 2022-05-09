package com.example.projectexam.presentation.activity
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.ArrayAdapter
//import android.widget.SearchView
//import com.example.projectexam.R
//import com.example.projectexam.databinding.ActivityHomeBinding
//import com.example.projectexam.databinding.ActivitySearchBinding
//
//class SearchActivity : AppCompatActivity() {
//
//    lateinit var binding: ActivitySearchBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivitySearchBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val name  : arrayOf("The Sims","PC","Linux","Xbox","PlayStation 2","PlayStation","GameCube","Classic Macintosh"
//        ,"Sandbox","console","pack","Teen","PC","PlayStation","Xbox","Apple Macintosh","Linux","Nintendo","Simulation",
//        "The Sims 4","Xbox One","PlayStation 4","macOS","Steam","PlayStation Store","Xbox Store","Singleplayer","Для одного игрока",
//        "Multiplayer","Atmospheric","Атмосфера","Для нескольких игроков","Казуальная игра","Смешная","Симулятор","Фэнтези",
//        "Funny","Fantasy","Для всей семьи","Милая","Кастомизация персонажа","Family Friendly","Character Customization",
//        "Cute","Реализм","Realistic","Сексуальный контент","Строительство","Building","Красивая","Расслабляющая","Sexual Content",
//        "3D","Relaxing","Steam Trading Cards","Мультипликация","Cartoony","Romance","Роман","Beautiful","Immersive Sim",
//        "LGBTQ+","Remote Play on Tablet","build","reality-based","Life Sim","life","family-simulator","Teen","Casual",
//        "Strategy","Simulation","The Sims: Vacation")
//
//        val searchAdapter = ArrayAdapter<String> = ArrayAdapter(
//            this,android.R.layout.item_home,
//            name
//        )
//
//        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                binding.searchView.clearFocus()
//                if (user.contains(query)){
//
//                    nameAdapter
//
//                }
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                TODO("Not yet implemented")
//            }
//        })
//    }
//}