<?php
   function toUtf8(&$item, $key) {
      $item = iconv("iso-8859-1","utf-8",$item);
   }
?>