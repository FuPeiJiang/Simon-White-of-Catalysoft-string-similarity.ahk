#NoEnv ; Recommended for performance and compatibility with future AutoHotkey releases.
#SingleInstance, force
ListLines Off
SendMode Input ; Recommended for new scripts due to its superior speed and reliability.
SetWorkingDir %A_ScriptDir% ; Ensures a consistent starting directory.
SetBatchLines, -1
#KeyHistory 0

#Include stringSimilarity.ahk

MsgBox % stringSimilarity("lecutre", "Lecture101_-_OK")

return

f3::Exitapp
