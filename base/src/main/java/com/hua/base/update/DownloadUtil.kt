package com.hua.base.update

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.text.TextUtils
import java.io.File

/**
 * Author: zlh
 * Data：2018/6/30-11:41
 * Description:
 */
class DownloadUtil {

    companion object {
        fun downloadForWeb(context: Context, url: String) {
            val uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }

        fun downloadApk(context: Context, url: String, title: String, fileName: String) {
            if (TextUtils.isEmpty(url)) return
            try {
                val uri = Uri.parse(url)
                val downloadManager: DownloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                val request = DownloadManager.Request(uri)
                request.setTitle(title)
                request.setVisibleInDownloadsUi(true)
                var filePath: String? = null
                if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {//外部存储卡
                    filePath = Environment.getExternalStorageDirectory().getAbsolutePath()
                }
                val downloadUpdateApkFilePath = filePath + File.separator + fileName
                deleteFile(downloadUpdateApkFilePath)
                val fileUri = Uri.fromFile(File(downloadUpdateApkFilePath))
                request.setDestinationUri(fileUri)
                val downloadUpdateApkId = downloadManager.enqueue(request)
            } catch (e: Exception) {
                e.printStackTrace()
                downloadForWeb(context, url)
            }
        }

        private fun deleteFile(fileStr: String): Boolean {
            val file = File(fileStr)
            return file.delete()
        }
    }
}