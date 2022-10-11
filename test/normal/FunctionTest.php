<?php
namespace Test\normal;

use PHPUnit\Framework\TestCase;

function bobbleSort($tmp):array
{
  if(is_array($tmp)) {
  // do something
  }
  return [];
}

class FunctionTest extends TestCase
{
    public function testInsertStringToBobbleSortShouldReturnEmpty() {
        $_tmp = bobbleSort('');
        self::assertEquals($_tmp, []);
    }
}