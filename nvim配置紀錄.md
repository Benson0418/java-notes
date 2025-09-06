# 如何從0開始為你的WSL配置neovim

## 1. 安裝WSL Ubuntu

沒什麼好說的，就直接默認安裝即可

## 2. 安裝neovim

```bash
sudo apt install nvim
```

此時會要你輸入密碼，別擔心你輸入啥都不會顯示，只要把密碼輸入完按下Enter，密碼正確自動會安裝的

當然你也可以先切到root帳戶(這裡不贅述)

## 3. 配置環境
小提示: 這裡涉及到基礎linux指令操作，ls -al可以看到目錄文件、隱藏檔案和詳細資料，以這個簡單指令輔助文件操作，其他指令我再單開另一篇筆記紀錄
```bash
mkdir -p ~/.config/nvim #創建多層資料夾
touch ~/.config/nvim/init.vim #在~/.config/nvim/init.vim 下創建 init.vim文件
```

## 4. 修改init.vim
預設主題來這裡看，vim的使用方式單已單開一頁筆記介紹

https://justinjoyce.dev/every-built-in-vim-color-scheme-with-screenshots/

```vimscript
syntax on 
colorscheme default " 這個部分填上你喜歡的主題

set tabstop=4    " 設定Tab空格，我這裡設定為4
set shiftwidth=4
set expandtab

set encoding=utf-8

filetype plugin indent on

```

~~*不會有人不知道怎麼退出vim吧XD*~~

## 5. 安裝gcc編譯器

```bash
sudo apt -y install build-essential # 這個套件已經包含gcc、g++等常用編譯器了，C++23以下都支援編譯
```

## 6. Hello, World!

```bash
cd # 回到$HOME
nvim code.cpp # 修改/建立code.cpp
```

書寫你的第一個C++程式

```c++
#include<bits/stdc++.h>
using namespace std;
int main(){
    cout<<"Hello, World!"<<endl;
    return 0;
}
```

編譯運行

```vim
:!g++ -std=c++17 -O2 % -o %< && ./%<
```

接著你就會看到

```
:!g++ -std=c++17 -O2 code.cpp -o code && ./code
hello, world

Press ENTER or type command to continue
```

恭喜你，成功寫出了第一個C++程式!

## 7. 配置編譯快捷鍵

傳統輸入外部命令編譯C++的方式實在太沒效率了，因此我們重返init.vim檔案，這段代碼附加上去

- gnome-terminal，請先`sudo apt install gnome-terminal -y`

```vimscript
map <F5> :w<CR>:!g++ -std=c++17 -O2 % -o %< && ./%<; read -p "Press Enter to continue..."<CR>

```

```vim
" ================================
" Compile & Run C++ in WSL using gnome-terminal (外部終端)
" ================================
function! CompileAndRun()
  let fileName = expand('%')
  
  if fileName =~ '\.cpp$'
    " 去掉副檔名作為可執行檔名稱
    let exeName = substitute(fileName, '\.cpp$', '', '')

    " 儲存檔案並編譯
    execute 'w | !g++ -std=c++17 -Wall -Wextra -Wpedantic -O2 -o ' . exeName . ' ' . fileName

    if v:shell_error == 0
      " 使用 gnome-terminal 執行程式，執行完停留
      let cmd = "gnome-terminal -- bash -c './" . exeName . "; read -p \"Press enter to exit...\"'"
      call system(cmd)
      redraw!
    endif
  else
    echo 'Not a C++ file'
  endif
endfunction

" ================================
" 快捷鍵綁定
" F5 → 編譯並執行當前檔案
map <F5> :call CompileAndRun()<CR>

" F9 → 儲存 + 清屏 + 編譯執行
map <F9> :w<CR>:!clear<CR>:call CompileAndRun()<CR>

```
- 請先`sudo apt install xterm -y`
```vim
" ================================
" Compile & Run C++ in WSL using XTerm
" ================================
function! CompileAndRun()
  let fileName = expand('%')
  
  if fileName =~ '\.cpp$'
    let exeName = substitute(fileName, '\.cpp$', '', '')

    " 儲存檔案並編譯
    execute 'w | !g++ -std=c++17 -Wall -Wextra -Wpedantic -O2 -o ' . exeName . ' ' . fileName

    if v:shell_error == 0
      " 使用 XTerm 執行程式，執行完停留
      let cmd = "xterm -hold -e './" . exeName . "'"
      call system(cmd)
      redraw!
    endif
  else
    echo 'Not a C++ file'
  endif
endfunction

" ================================
" 快捷鍵綁定
" F5 → 編譯並執行當前檔案
map <F5> :call CompileAndRun()<CR>

" F9 → 儲存 + 清屏 + 編譯執行
map <F9> :w<CR>:!clear<CR>:call CompileAndRun()<CR>

```

## 8. vim插件

在此之前，請確保WSL裡面已經有curl 和 git了，輸入`which curl`和`which git`查看，安裝Ubuntu發行版默認是有附帶的
沒有的請先`sudo apt install curl git`一下



安裝vim-plug，按照[官網](https://github.com/junegunn/vim-plug?tab=readme-ov-file)給的方式輸入這個命令

```bash
sh -c 'curl -fLo "${XDG_DATA_HOME:-$HOME/.local/share}"/nvim/site/autoload/plug.vim --create-dirs \
       https://raw.githubusercontent.com/junegunn/vim-plug/master/plug.vim'
```

接著跳轉過來

```bash
cd ~/.local/share/nvim/site/autoload
```

會看到`plug.vim`

回到

```bash
cd ~/.config/nvim
nvim init.vim
```

將這裡面的東西附加進去

```vimscript
call plug#begin('~/.local/share/nvim/plugged')

call plug#end()
```

## 9. autopair

在這裡面插入

```vimscript
call plug#begin('~/.local/share/nvim/plugged')
	Plug 'jiangmiao/auto-pairs'
call plug#end()
```

輸入

```vim
:wq
```

退出重進

再

```vimscript
:PlugInstall
```

就可以享受補全括號的待遇啦~

## 10. coc.nvim

`sudo apt install nodejs`

```vimscript
Plug 'neoclide/coc.nvim', {'branch': 'release'}
```



### 10.1 LSP(language server protocol)

**LSP（語言伺服器協定）** 是一個標準化的 **編程語言服務接口**，它的目標是讓編輯器/IDE 可以統一跟各種程式語言溝通，而不用每個 IDE 都自己寫補全、跳轉、診斷的邏輯。

首先，確保自己有nodejs和npm

```bash
node -v
npm -v
```

沒有的話，自己

```bash
sudo apt install nodejs npm -y
```

接著安裝`clangd`，請注意，不是`clang`

提供智能補全的效果

```bash
sudo apt install clangd
```

接著進入vim

輸入

```vim
:CocInstall coc-clangd
```

## 10.2 配置Coc.nvim

回到

```bash
cd ~/.config/nvim
touch coc.vim #創建一個空文件叫做coc.vim
```

把[這裡](https://raw.githubusercontent.com/neoclide/coc.nvim/master/doc/coc-example-config.vim)面的內容先貼進coc.vim裡面

回到init.vim

加入

```vimscript
source ~/.config/nvim/coc.vim
```

```vim
" TAB 自動補全
inoremap <silent><expr> <TAB> pumvisible() ? "\<C-n>" : "\<TAB>"
inoremap <silent><expr> <S-TAB> pumvisible() ? "\<C-p>" : "\<S-TAB>"
inoremap <silent><expr> <CR> pumvisible() ? coc#_select_confirm() : "\<CR>"
```

Enter 自動補全

Shift tab / Ctrl+p向上選擇

tab / Ctrl+n 向下選擇

## 11 vim-airline

```vimscript
Plug 'vim-airline/vim-airline'
Plug 'vim-airline/vim-airline-themes'
```

## 12 fzf

```vimscript
 Plug 'junegunn/fzf', { 'dir': '~/.fzf', 'do': './install --all' }
 Plug 'junegunn/fzf.vim'
 
```

```vimscript
" fzf
let mapleader = ","
nnoremap <leader>f :Files<CR>
nnoremap <leader>b :Buffers<CR>
nnoremap <leader>l :Lines<CR>
```

## fish

一款終端

`sudo apt install fish`安裝，代替bash

## startify

替換nvim啟動介面

可以透過，來實現
```vim

let g:startify_custom_header = [
\ "     __  ___  ____ _          __        _             ",
\ "  /\\ \\ \\/ _ \\| ___( )__    /\\ \\ \\__   _(_)_ __ ___  ",
\ " /  \\/ / (_) |___ \\/ __|  /  \\/ /\\ \\ / / | '_ ` _ \\ ",
\ "/ /\\  / \\__, |___) \\__ \\ / /\\  /  \\ V /| | | | | | |",
\ "\\_\\ \\/    /_/|____/|___/ \\_\\ \\/    \\_/ |_|_| |_| |_|"
\ ]

```



## indentline

```vimscript

" 顯示縮排線
let g:indentLine_enabled = 1
let g:indentLine_char = '┆'
let g:indentLine_fancy = 1


```



## nerd-Tree

```vimscript
" 啟用 NERDTree 開啟
map <C-n> :NERDTreeToggle<CR>  " Ctrl+n 切換檔案樹

" 新檔案 / 新目錄快速操作
map <leader+m> :NERDTreeMirror<CR>

" 開啟 Vim 時自動顯示 NERDTree
autocmd VimEnter * NERDTree
```

## nerdcommenter

- `Ctrl-w h` → 切到左邊窗口
- `Ctrl-w l` → 切到右邊窗口
- `Ctrl-w j` → 切到下方窗口
- `Ctrl-w k` → 切到上方窗口

## rainbow

## vim-autoformat

## devicons

