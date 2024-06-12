package com.example.session1

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Request.Builder
import okhttp3.Response
import java.io.IOException
import kotlin.Exception

class MainActivity : AppCompatActivity() {
    // 建立 okhttpClient
    var client: OkHttpClient = OkHttpClient().newBuilder().build()

    private var toolbar: Toolbar? = null
    private var tabLayout: TabLayout? = null
    private var viewpager: ViewPager2? = null
    private var navigation: BottomNavigationView? = null
    private var adapter: FragmentViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // API 位址
        getUrl("https://opendata.cwa.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=rdec-key-123-45678-011121314")
        /*try {
            init()
            setToolbar()
            setTabLayout()
            setviewpager()
            setnavigation()
        } catch (e: Exception) {
            Log.i("Error", "e = $e")
        }*/
    }
    /*private fun init() {
        toolbar = findViewById(R.id.toolbar)
        tabLayout = findViewById(R.id.tableLayout)
        viewpager = findViewById(R.id.viewPager2)
        navigation = findViewById(R.id.bottomNavigationView)
    }
    private fun setToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Main title"
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.subtitle = "副標題"
        toolbar.setSubtitleTextColor(Color.BLACK)
        toolbar.navigationIcon = getDrawable(R.mipmap.right_arrow)
        toolbar.contentInsetStartWithNavigation = 0
        toolbar.setNavigationOnClickListener { v: View? ->
            Toast.makeText(
                this,
                "End",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    private fun menuIconWithText(r: Drawable?): CharSequence {
        r!!.setBounds(0, 0, r.intrinsicWidth, r.minimumHeight)
        val sb = SpannableString("     $String")
        val imageSpan = ImageSpan(r, ImageSpan.ALIGN_BOTTOM)
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return sb
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0, 0, 0, "第一個選項")
        menu?.add(0, 1, 1, "第二個選項")
        menu?.add(0, 2, 2, "第三個選項")
        menu?.add(0, 3, 3, menuIconWithText(getDrawable(R.mipmap.eye_oepn)))
        menu?.add(0, 4, 4,  "外部選項")?.setShowAsAction(
            MenuItem.SHOW_AS_ACTION_IF_ROOM
        )
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            0 -> Toast.makeText(this, "選一", Toast.LENGTH_SHORT).show()
            1 -> Toast.makeText(this, "選二", Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(this, "選三", Toast.LENGTH_SHORT).show()
            3 -> Toast.makeText(this, "選帶Icon的Item", Toast.LENGTH_SHORT).show()
            4 -> Toast.makeText(this, "選在外面的", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun setTabLayout() {
        tabLayout!!.addTab(tabLayout!!.newTab().setText(R.string.onepage))
        tabLayout!!.addTab(tabLayout!!.newTab().setText(R.string.twopage))
        tabLayout!!.addTab(tabLayout!!.newTab().setText(R.string.threepage))

        tabLayout!!.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(p0: TabLayout.Tab?) {
                if (p0 != null) {
                    viewpager!!.currentItem = p0.position
                }
                if (p0 != null) {
                    navigation!!.menu.getItem(p0.position).isChecked = true
                }
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {}
            override fun onTabReselected(p0: TabLayout.Tab?) {}
        })
    }
    private fun setviewpager() {
        adapter = FragmentViewPagerAdapter(this)
        viewpager!!.adapter = adapter
        viewpager!!.currentItem = 0
        viewpager!!.registerOnPageChangeCallback(object  : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewpager!!.currentItem = position
                tabLayout!!.getTabAt(position)!!.select()
            }
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })
    }
    private fun setnavigation() {
        navigation!!.setOnItemSelectedListener { item ->
            try {
                val itemId = item.itemId
                if (itemId == R.id.onepage) {
                    viewpager!!.currentItem = 0
                    tabLayout!!.getTabAt(0)!!.select()
                } else if (itemId == R.id.twopage) {
                    viewpager!!.currentItem = 1
                    tabLayout!!.getTabAt(1)!!.select()
                } else if (itemId == R.id.threepage) {
                    viewpager!!.currentItem = 2
                    tabLayout!!.getTabAt(2)!!.select()
                }
            } catch (e: Exception) {
                Log.i("Error", "e = $e")
            }
            true
        }
    }*/
    // API 解析
    fun getUrl(url: String?) {
        // 建立 Request, 設置連線資訊
        val request: Request? = url?.let {
            Builder()
                .url(it)
                .build()
        }

        // 建立 Call
        val call: Call? = request?.let { client.newCall(it) }

        // 執行call連線到網址
        call?.enqueue(object : Callback {
            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                val result: String = response.body?.string() ?: ""
                Log.i("Okhttp", "get = $result")
            }

            override fun onFailure(call: Call, e: IOException) {
                // 連線失敗
                Log.i("Okhttp", "get error = $e")
            }
        })
    }
}