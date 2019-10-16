package com.leetcode.recursion;

import java.util.*;

/**
 * K4(ON(SO3)2)2
 */
public class LeetCode726 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Solution726 solution726 = new Solution726();
        solution726.countOfAtoms("(((U42Se42Fe10Mc31Rh49Pu49Sb49)49V39Tm50Zr44Og6)33((W2Ga48Tm14Eu46Mt12)23(RuRnMn11)7(Yb15Lu34Ra19CuTb2)47(Md38BhCu48Db15Hf12Ir40)7CdNi21(Db40Zr24Tc27SrBk46Es41DsI37Np9Lu16)46(Zn49Ho19RhClF9Tb30SiCuYb16)15)37(Cr48(Ni31)25(La8Ti17Rn6Ce35)36(Sg42Ts32Ca)37Tl6Nb47Rh32NdGa18Cm10Pt49(Ar37RuSb30Cm32Rf28B39Re7F36In19Zn50)46)38(Rh19Md23No22PoTl35Pd35Hg)41)50");
        Solution726 solution726_1 = new Solution726();
        //solution726_1.countOfAtoms("((Bi16LrSc30As49As23La13La(Ba21Re28BkRf40DbP29SeSe41La27Cn16)48(TcRn)49(Sb28Ti4Po35Mn16)21(Ta36Tl2Br5Dy21S41)6(Bh37Li36O20Tb48)24Cr43Pd11Pu39OgYb43Zr35FmHe44(Rh35BiLaCf4RnHLi10RgLuRg)3(Cn15PbS44Nd18)8)25((Hs11B41Rf46)20(At48Te45)32(Cs15Mt19OgHs34Ts5La33Ga23Np50Dy33O24)4)13((Po21ZnPdK27Pm16TlCo34Nd30Y4N)16(Nh2BaNa28Ga15LuAl38)17(Rb23ReRf2Rf33I32Te48Bh)50(Cf37Ne32W33BeRgIr21Cs34Mc17Zn43)43(Ho23ArEs38Er40Tb8DyIn41Tc36Hg21Cl9)42(Y8B25Ts16S10Fr2Lv22Po6)2(Zn46N34Ds7Sg20HoRf31P25ZrIHo22)40(FeRh50Kr9ThPt49)37(TaLrKr35Kr12SrCd26Xe28Mt26CnFl)43)23)17");
        Solution726 solution726_2 = new Solution726();
        //solution726_2.countOfAtoms("(((U42Se42Fe10Mc31Rh49Pu49Sb49)49V39Tm50Zr44Og6)33((W2Ga48Tm14Eu46Mt12)23(RuRnMn11)7(Yb15Lu34Ra19CuTb2)47(Md38BhCu48Db15Hf12Ir40)7CdNi21(Db40Zr24Tc27SrBk46Es41DsI37Np9Lu16)46(Zn49Ho19RhClF9Tb30SiCuYb16)15)37(Cr48(Ni31)25(La8Ti17Rn6Ce35)36(Sg42Ts32Ca)37Tl6Nb47Rh32NdGa18Cm10Pt49(Ar37RuSb30Cm32Rf28B39Re7F36In19Zn50)46)38(Rh19Md23No22PoTl35Pd35Hg)41)50");
        System.out.println("执行时间为：" + (System.currentTimeMillis() - time) + "毫秒");
    }
}

class Solution726 {
    List<String> listWithoutSign = new ArrayList<>();
    List<String> listTemp = new ArrayList<>();
    StringBuilder toAddAfterCount = new StringBuilder();
    StringBuilder toAdd = new StringBuilder();//需要切分添加的字符串

    public String countOfAtoms(String formula) {
        listWithoutSign.add(formula);
        dealWithFormula();//去除括号得到 listWithoutSign 其中会有数字
        return getAtoms();
    }

    /**
     * 递归处理后
     * list中存储去除括号的表达式（拆分后）
     */
    public void dealWithFormula() {
        listTemp.clear();
        boolean isWithSignFlag = false;
        for(String s:listWithoutSign){
            if(s.contains("(")){
                listTemp.add(s);
                isWithSignFlag = true;
            }
        }
        if(!isWithSignFlag){
            return;
        }
        String countString = "";
        int countNum;
        for(int k = 0;k<listTemp.size();k++){
            String formula = listTemp.get(k);
            listWithoutSign.remove(formula);
            int flag = 0;
            for (int i = 0; i < formula.length(); i++) {
                if (formula.charAt(i) != '(' && formula.charAt(i) != ')') {
                    toAdd.append(formula.charAt(i));
                }
                if (formula.charAt(i) == '(') {
                    if (flag == 0 && toAdd.length() != 0) {
                        listWithoutSign.add(toAdd.toString());
                        toAdd.setLength(0);//第一次遇到括号，将游标字符置空，前面获得的游标值存入
                    }
                    if(flag != 0){
                        toAdd.append(formula.charAt(i));
                    }
                    flag++;
                }
                if (formula.charAt(i) == ')') {
                    flag--;
                    if (flag == 0) {
                        if(formula.charAt(i+1) >= '0' && formula.charAt(i+1) <= '9'){
                            i++;
                        }
                        while (formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
                            countString += formula.charAt(i);
                            //最后一位 或者 后面不是数字
                            if(i == formula.length()-1){
                                break;
                            }else{
                                if(!(formula.charAt(i+1) >= '0' && formula.charAt(i+1) <= '9')){
                                    break;
                                }
                            }
                            i++;
                        }
                        //去括号的串  存进去
                        toAddAfterCount.setLength(0);
                        if(!"".equals(countString)){
                            for(int num = 0;num < Integer.parseInt(countString);num++){
                                toAddAfterCount.append(toAdd);
                            }
                        }
                        else{
                            toAddAfterCount.append(toAdd);
                        }
                        listWithoutSign.add(toAddAfterCount.toString());
                        toAdd.setLength(0);
                        countString = "";
                    }else{
                        toAdd.append(formula.charAt(i));
                    }
                }
            }
            if(toAdd.length() != 0){
                listWithoutSign.add(toAdd.toString());
                toAdd.setLength(0);
            }
        }
        dealWithFormula();
    }

    /**
     * 统计各元素个数
     */
    public String getAtoms(){
        TreeMap<String,Integer> treeMap = new TreeMap();
        Iterator<String> iterator = listWithoutSign.iterator();
        String atom = "";
        String atomNum = "";
        String Result = "";
        for(String s:listWithoutSign){
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    atomNum += s.charAt(i);
                }else{
                    if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                        if(atom != null && !"".equals(atom)){
                            if("".equals(atomNum)){
                                atomNum = "1";
                            }
                            if(treeMap.containsKey(atom)){
                                treeMap.put(atom,treeMap.get(atom)+Integer.parseInt(atomNum));
                            }else{
                                treeMap.put(atom,Integer.parseInt(atomNum));
                            }
                            atomNum = "";
                            atom = "";
                        }
                    }
                    atom += s.charAt(i);
                }

            }
        }
        if("".equals(atomNum)){
            atomNum = "1";
        }
        if(treeMap.containsKey(atom)){
            treeMap.put(atom,treeMap.get(atom)+Integer.parseInt(atomNum));
        }else{
            treeMap.put(atom,Integer.parseInt(atomNum));
        }
        Iterator iteratorKey = treeMap.keySet().iterator();
        for(String s:treeMap.keySet()){
            if(treeMap.get(s) != 1){
                Result += s + treeMap.get(s);
            }else{
                Result += s;
            }

        }
        return Result;
    }
}