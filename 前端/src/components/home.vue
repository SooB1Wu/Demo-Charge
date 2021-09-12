<template>
    <p></p>
</template>

<script>

    //配置本机ip地址
    export default {
        name: "home",
        created() {

            let lh_url='http://10.135.130.249:8081'
            //let lh_url='http://175.27.157.107:8081'
            this.$router.push({
                path: '/pc',
                query: {
                    lhurl: lh_url
                }
            })
        }
    }
</script>

<style scoped>

</style>