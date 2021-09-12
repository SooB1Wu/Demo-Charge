<template>

    <el-container>
        <el-container>
            <el-aside width="30%">
                <div style="margin-top: 60px">
                    <el-row>
                        <el-col :span="10">
                            <div>
                                <br>
                            </div>
                        </el-col>
                        <el-col :span="14">
                        </el-col>
                    </el-row>
                </div>
            </el-aside>
            <el-aside width="40%">
                <div style="width: 60%;margin-left: 15%;margin-top: 120px">
                    <el-form ref="form" :model="form" label-width="100px">
                        <el-form-item label="Z">
                            <el-input v-model="form.Z"></el-input>
                        </el-form-item>
                        <el-form-item label="C">
                            <el-input v-model="form.C"></el-input>
                        </el-form-item>
                        <el-form-item label="A">
                            <el-input v-model="form.A"></el-input>
                        </el-form-item>
                        <br>
                        <el-form-item>
                            <el-button type="primary" @click="onSubmit">立即提交</el-button>
                        </el-form-item>
                    </el-form>
                </div>
                <div style="width: 50%;margin-left: 25%">
                    <el-card align="left" style="width: 100%">
                        <div slot="header">
                        </div>
                        <p>{{z1}}</p>
                        <p>{{z2}}</p>
                        <p>{{flag}}</p>
                        <p>{{runtime}}</p>
                    </el-card>
                </div>
            </el-aside>
            <el-main>
                <div style="margin-top: 40px">
                </div>
            </el-main>

        </el-container>
    </el-container>


</template>

<script>

    import axios from "axios"
    //配置本机ip地址
    //let lh_url='http://10.196.16.19:8081'

    export default {

        name: "home",
        data(){
            return{
                form: {
                    Z: '1m2 2m3 3m4 4m5 5m6',
                    C: '4',
                    A: '1m3 1m7 2m7 1m9 2m2 3m4'
                },
                z1: '',
                z2: '',
                flag:'',
                err:'',
                lhurl:this.$route.query.lhurl
            }
        },
        methods:{
            onSubmit(){
                const _this = this
                let data = this.form
                let eu_url=this.lhurl+'/soob'//请求格式化
                console.log(eu_url);
                //数据格式检查
                if(data.Z==''||data.C==''||data.A==''){
                    alert("请输入数据")
                    return ;
                }
                for(let i=0;i<data.Z.length;i++){
                    let c=data.Z.charAt(i);
                    if((c<"0"||c>"9")&&c!=" "&&c!="m") {
                        alert("数据格式错误")
                        return ;
                    }
                }
                for(let i=0;i<data.A.length;i++){
                    let c=data.A.charAt(i);
                    if((c<"0"||c>"9")&&c!=" "&&c!="m") {
                        alert("数据格式错误")
                        return ;
                    }
                }
                axios.post(eu_url, {
                    Z:data.Z,
                    A:data.A,
                    C:data.C
                }).then(function (response) {
                    let _data=response.data
                    console.log(_data)
                    _this.z1 = _data.z1
                    _this.z2 = _data.z2
                    _this.flag = _data.flag
                    if(_data.err=='err')
                        alert("数据格式错误")
                    else {
                        if (_this.z1 == '')
                            _this.z1 = 'null'
                        if (_this.z2 == '')
                            _this.z2 = 'null'
                        if (_this.flag == '')
                            _this.flag = 'null'
                        _this.z1 = 'Z1: ' + _this.z1;
                        _this.z2 = 'Z2: ' + _this.z2;
                        _this.flag = 'flag: ' + _this.flag;
                    }
                }).catch(function (error) {
                    console.log(error);
                })
            }
        },
    }
</script>

<style scoped>

</style>