package com.cameo.dropbox

import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.v2.DbxClientV2
import collection.JavaConverters._

object Connect extends App {
  override def main(args: Array[String]): Unit = {
    val config = DbxRequestConfig.newBuilder(client_identifier)
    val client = new DbxClientV2(config.build, access_token)
    val account = client.users.getCurrentAccount
    println(s"account.getEmail: ${account.getEmail}")
    val result = client.files.listFolder("")
    result.getEntries.asScala.foreach(println)
  }
}
